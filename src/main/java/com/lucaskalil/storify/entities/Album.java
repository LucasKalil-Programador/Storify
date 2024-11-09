package com.lucaskalil.storify.entities;

import java.time.Instant;
import java.util.UUID;

import com.lucaskalil.storify.entities.enums.PrivacySettings;

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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import com.lucaskalil.storify.entities.enums.ModifyAccessSettings;

@Entity
@Table(name = "album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PrivacySettings privacy;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ModifyAccessSettings modifyAccess;

    @Column(nullable = false, length = 512)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner", referencedColumnName = "id", nullable = false)
    private User owner;

    @Column(name = "created_date", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Instant createdDate;

    @Column(name = "modified_date", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Instant modifiedDate;

    public Album() {}

    public Album(PrivacySettings privacy, ModifyAccessSettings modifyAccess, String name, User owner,
            Instant createdDate, Instant modifiedDate) {
        this.privacy = privacy;
        this.modifyAccess = modifyAccess;
        this.name = name;
        this.owner = owner;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public PrivacySettings getPrivacy() {
        return privacy;
    }

    public void setPrivacy(PrivacySettings privacy) {
        this.privacy = privacy;
    }

    public ModifyAccessSettings getModifyAccess() {
        return modifyAccess;
    }

    public void setModifyAccess(ModifyAccessSettings modifyAccess) {
        this.modifyAccess = modifyAccess;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public Instant getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Instant modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    
    
}
