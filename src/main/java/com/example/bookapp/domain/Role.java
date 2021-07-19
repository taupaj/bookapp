package com.example.bookapp.domain;

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
@Table(name = "administration_role")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
        name = "administration_role_group",
        joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "group_id", referencedColumnName = "id")})
    private Set<Group> groups = new HashSet<>();


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

    public Role name(String name) {
        this.name = name;
        return this;
    }

    public Role groups(Set<Group> groups) {
        groups.forEach(this::addGroup);
        return this;
    }

    public void addGroup(Group group) {
        groups.add(group);
        group.getRoles().add(this);
    }

    public void removeGroup(Group group) {
        groups.remove(group);
        group.getRoles().remove(this);
    }

    public void removeGroups() {
        new HashSet<>(groups).forEach(this::removeGroup);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Role role = (Role) o;
        if (role.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, role.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Role{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", groups=" + groups +
            '}';
    }
}
