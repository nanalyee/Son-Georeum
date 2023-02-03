package com.bbb.pjtname.db.repository;

import com.bbb.pjtname.db.domain.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {

    List<Favorite> findByUser_Id(Long userId);

    Favorite findByUser_IdAndWord_Id(Long userId, Long wordId);
}
