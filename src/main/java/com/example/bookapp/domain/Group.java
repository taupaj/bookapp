package com.example.bookapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "administration_group")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Group implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
    @JsonIgnore
    @ManyToMany(mappedBy = "groups", cascade = CascadeType.MERGE)
    private Set<Role> roles = new HashSet<>();
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "administration_group_action",
        joinColumns = {@JoinColumn(name = "group_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "action_id", referencedColumnName = "id")})
    private Set<Action> actions = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group name(String name) {
        this.name = name;
        return this;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public Set<Action> getActions() {
        return actions;
    }

    public void setActions(Set<Action> actions) {
        actions.forEach(this::addAction);
    }

    public Group actions(Set<Action> actions) {
        actions.forEach(this::addAction);
        return this;
    }

    public void addAction(Action action) {
        actions.add(action);
        action.getGroups().add(this);
    }

    public void removeAction(Action action) {
        actions.remove(action);
        action.getGroups().remove(this);
    }

    public void removeActions() {
        new HashSet<>(actions).forEach(this::removeAction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Group group = (Group) o;
        if (group.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, group.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Group{" +
            "id=" + id +
            ", name='" + name + "'" +
            '}';
    }
}
