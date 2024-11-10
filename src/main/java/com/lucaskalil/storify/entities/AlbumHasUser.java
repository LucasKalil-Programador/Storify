package com.lucaskalil.storify.entities;

import java.util.UUID;

import com.lucaskalil.storify.entities.enums.AccessSettings;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AlbumHasUser {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id", nullable = false)
    private Album album;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccessSettings accessSettings;

    public AlbumHasUser() {}

    public AlbumHasUser(Album album, User user, AccessSettings accessSettings) {
        this.album = album;
        this.user = user;
        this.accessSettings = accessSettings;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AccessSettings getAccessSettings() {
        return accessSettings;
    }

    public void setAccessSettings(AccessSettings accessSettings) {
        this.accessSettings = accessSettings;
    }
}
