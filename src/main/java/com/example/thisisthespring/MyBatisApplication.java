package com.example.thisisthespring;

import java.util.Optional;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.thisisthespring.domain.article.entity.Article;
import com.example.thisisthespring.domain.article.mapper.ArticleMapper;
import com.example.thisisthespring.domain.user.entity.Member;
import com.example.thisisthespring.domain.user.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class MyBatisApplication implements ApplicationRunner {

	private final MemberMapper memberMapper;
	private final ArticleMapper articleMapper;

	@Override
	public void run(ApplicationArguments args) {
		// 1) 멤버 수 조회 + 로그
		int memberCount = memberMapper.selectAllCount();
		log.info("Member count = {}", memberCount);

		// 2) 이메일로 멤버 조회
		String email = "kim@example.com"; // data.sql에 넣은 이메일로 맞추세요
		Optional<Member> memberOpt = memberMapper.selectByEmail(email);

		if (memberOpt.isEmpty()) {
			log.warn("No member found by email={}", email);
			return;
		}

		Member member = memberOpt.get();
		log.info("Found member: id={}, name={}, email={}, age={}",
			member.getId(), member.getName(), member.getEmail(), member.getAge());

		// 3) 멤버 id로 게시글(Article) 객체 생성
		Article article = Article.builder()
			.title("첫 게시글")
			.description("MyBatis로 생성한 게시글 객체입니다.")
			.memberId(member.getId())
			.build();

		log.info("Created Article object (not persisted yet): {}", article);

		// (선택) 실제 DB에 INSERT까지 하고 싶으면 아래 활성화
		// insert 후 @Options(useGeneratedKeys=true) 설정이 정상이라면 article.id가 채워집니다.
		int inserted = articleMapper.insert(article);
		log.info("Inserted article rows={}, generated articleId={}", inserted, article.getId());
	}
}
