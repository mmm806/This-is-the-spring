package com.example.thisisthespring.domain.article.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.thisisthespring.domain.article.entity.Article;

@Mapper
public interface ArticleMapper {

	@Select("SELECT * FROM article")
	List<Article> selectAll();

	@Select("SELECT COUNT(*) FROM article")
	int selectAllCount();

	@Select("SELECT * FROM article WHERE id=#{id}")
	Optional<Article> selectById(@Param("id")Long id);

	@Select("SELECT * FROM article WHERE member_id=#{memberId}")
	List<Article> selectByMemberId(@Param("memberId")Long memberId);

	@Insert("""
        INSERT INTO article (title, description, created, updated, member_id)
        VALUES (#{article.title}, #{article.description}, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, #{article.memberId})
    """)
	@Options(useGeneratedKeys = true, keyProperty = "article.id", keyColumn = "id")
	int insert(@Param("article") Article article);

	@Update("""
        UPDATE article
        SET title = #{title},
            description = #{description},
            updated = CURRENT_TIMESTAMP
        WHERE id = #{id}
    """)
	int update(@Param("id") Long id, @Param("title") String title, @Param("description") String description);

	@Delete("DELETE FROM article WHERE id = #{id}")
	int deleteById(@Param("id") Long id);

	@Delete("DELETE FROM article WHERE member_id = #{memberId}")
	int deleteByMemberId(@Param("memberId") Long memberId);

	@Delete("DELETE FROM article")
	int deleteAll();
}

