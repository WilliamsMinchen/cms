package com.xzjie.cms.repository;

import com.xzjie.cms.dto.ArticleHotResult;
import com.xzjie.cms.model.ArticleHot;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ArticleHotRepository extends JpaRepository<ArticleHot, Long>, JpaSpecificationExecutor<ArticleHot> {

    @Query(value = "SELECT new com.xzjie.cms.dto.ArticleHotResult(b.id,b.articleId,a.title,b.sort,b.createDate) FROM Article a, ArticleHot b where a.id = b.articleId")
    Page<ArticleHotResult> findArticleHot(Pageable pageable);

//    ArticleHot findByArticleId(Long ArticleId);

    boolean existsByArticleId(Long articleId);
}