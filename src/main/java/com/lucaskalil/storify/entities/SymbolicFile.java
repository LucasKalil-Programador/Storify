package com.lucaskalil.storify.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.lucaskalil.storify.entities.enums.FileType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "file")
public class SymbolicFile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 255)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FileType type;

    @Column(nullable = false, length = 512)
    private String location;

    @Column(nullable = false)
    private Long size;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner", referencedColumnName = "id", nullable = false)
    private User owner;

    @ManyToMany(mappedBy = "files", fetch = FetchType.LAZY)
    private List<Album> albums = new ArrayList<>();

    public SymbolicFile() {}

    public SymbolicFile(String name, FileType type, String location, Long size, User owner) {
        this.name = name;
        this.type = type;
        this.location = location;
        this.size = size;
        this.owner = owner;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FileType getType() {
        return type;
    }

    public void setType(FileType type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<Album> getAlbums() {
        return albums;
    }
}
