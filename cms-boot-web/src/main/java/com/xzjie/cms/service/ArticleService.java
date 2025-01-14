package com.xzjie.cms.service;

import com.xzjie.cms.client.dto.SearchDto;
import com.xzjie.cms.client.vo.CaseVo;
import com.xzjie.cms.client.vo.ArticleDetailVo;
import com.xzjie.cms.core.service.BaseService;
import com.xzjie.cms.dto.ArticleHotResult;
import com.xzjie.cms.dto.ArticleQueryDto;
import com.xzjie.cms.dto.ArticleRecommendStatResult;
import com.xzjie.cms.dto.CategoryTree;
import com.xzjie.cms.model.Article;
import com.xzjie.cms.model.ArticleHot;
import com.xzjie.cms.model.ArticleRecommendStat;
import com.xzjie.cms.model.Category;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;


public interface ArticleService extends BaseService<Article> {

    Article getArticle(Long id);

    boolean updatePraise(Long id);

    ArticleDetailVo getArticleDetail(Long id);

    Page<Article> getArticle(SearchDto dto);

    Page<Article> getArticle(ArticleQueryDto dto);

    Category getCategory(Long id);

    List<CaseVo> getCaseData(Long categoryId,ArticleQueryDto query);

    List<Category> getCategory();

    Page<Category> getCategory(Integer page, int size, Category category);

    List<CategoryTree> getCategoryTree();

    boolean saveCategory(Category category);

    boolean updateCategory(Category category);

    boolean deleteCategory(Long id);

    Page<ArticleHotResult> getArticleHot(Integer page, int size);

    boolean saveArticleHot(Set<Long> ids);

    boolean updateArticleHot(ArticleHot articleHot);

    boolean deleteArticleHot(Set<Long> ids);

    Page<ArticleRecommendStatResult> getRecommendStat(Integer page, int size);

    boolean saveRecommendStat(Set<Long> ids);

    boolean updateRecommendStat(ArticleRecommendStat recommendStat);

    boolean deleteRecommendStat(Set<Long> ids);
}
