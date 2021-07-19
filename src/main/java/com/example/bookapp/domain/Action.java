package com.example.bookapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "administration_action")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Action implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "url")
    private String url;
    
    @Column(name = "method")
    private String method;
    
    @Column(name = "section")
    private String section;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "actions", cascade = CascadeType.MERGE)
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
    
    public Action name(String name) {
        this.name = name;
        return this;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Action description(String description) {
        this.description = description;
        return this;
    }
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    public Action url(String url) {
        this.url = url;
        return this;
    }
    
    public String getMethod() {
        return method;
    }
    
    public void setMethod(String method) {
        this.method = method;
    }
    
    public Action method(String method) {
        this.method = method;
        return this;
    }
    
    public String getSection() {
        return section;
    }
    
    public void setSection(String section) {
        this.section = section;
    }
    
    public Action section(String section) {
        this.section = section;
        return this;
    }
    
    public Set<Group> getGroups() {
        return groups;
    }
    
    public void setGroups(Set<Group> groups) {
        groups.forEach(this::addGroup);
    }
    
    public Action groups(Set<Group> groups) {
        groups.forEach(this::addGroup);
        return this;
    }
    
    public void addGroup(Group group) {
        groups.add(group);
        group.getActions().add(this);
    }
    
    public void removeGroup(Group group) {
        groups.remove(group);
        group.getActions().remove(this);
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
        Action action = (Action) o;
        if (action.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, action.id);
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
    
    @Override
    public String toString() {
        return "Action{" +
            "id=" + id +
            ", name='" + name + "'" +
            ", description='" + description + "'" +
            ", url='" + url + "'" +
            ", method='" + method + "'" +
            ", section='" + section + "'" +
            '}';
    }
}
