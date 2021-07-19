package com.example.bookapp.filter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserFilter implements Serializable {

    private static final long serialVersionUID = -6611227068705141126L;

    private Long id;
    private List<Long> ids;
    private String firstName;
    private String lastName;
    private String username;
    private Boolean isAuthor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getAuthor() {
        return isAuthor;
    }

    public void setAuthor(Boolean author) {
        isAuthor = author;
    }

    @Override
    public String toString() {
        return "UserFilter{" +
                "id=" + id +
                ", ids=" + ids +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", isAuthor=" + isAuthor +
                '}';
    }
}
