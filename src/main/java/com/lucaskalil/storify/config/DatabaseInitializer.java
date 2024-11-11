package com.lucaskalil.storify.config;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.lucaskalil.storify.entities.Album;
import com.lucaskalil.storify.entities.AlbumHasUser;
import com.lucaskalil.storify.entities.Plan;
import com.lucaskalil.storify.entities.SymbolicFile;
import com.lucaskalil.storify.entities.User;
import com.lucaskalil.storify.entities.enums.AccessSettings;
import com.lucaskalil.storify.entities.enums.FileType;
import com.lucaskalil.storify.entities.enums.ModifySettings;
import com.lucaskalil.storify.entities.enums.PrivacySettings;
import com.lucaskalil.storify.entities.enums.UserStatus;
import com.lucaskalil.storify.repositories.AlbumRepository;
import com.lucaskalil.storify.repositories.PlanRepository;
import com.lucaskalil.storify.repositories.SymbolicFileRepository;
import com.lucaskalil.storify.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SymbolicFileRepository symbolicFileRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        System.out.println("Inicializando banco de dados...");

        planRepository.save(new Plan("Plano Básico", 100L, "default"));
        planRepository.save(new Plan("Plano Avançado", 500L));
        Plan primiumPlan = planRepository.save(new Plan("Plano Premium", 1000L));

        User user = userRepository.save(new User("Lucas Kalil", "lucas.kalil2018@gmail.com", "pwd", primiumPlan, 0L, Instant.now(), Instant.now(), UserStatus.NO_PROBLEMS, "+55 (71) 99337-0283", "Brasil"));
   
        SymbolicFile file = symbolicFileRepository.save(new SymbolicFile("foto_em_familia.png", FileType.PNG, "AWS:0XGJWOCUAANSO", 1000L, user));

        Album album = albumRepository.save(new Album(PrivacySettings.PRIVATE, ModifySettings.OWNER, "fotos familia", user, Instant.now(), Instant.now()));
        
        AlbumHasUser albumHasUser = new AlbumHasUser(album, user, AccessSettings.OWNER);

        user.getAlbumUsers().add(albumHasUser);
        user.getFiles().add(file);

        Optional<User> user2 = userRepository.findById(user.getId());
        
        album.getFiles().add(file);
        albumRepository.save(album);

        System.out.println(user2.get().getFiles());
        System.out.println(user2.get().getAlbumUsers());
    }
}


