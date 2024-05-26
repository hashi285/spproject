package org.example.friendexam.레포지토리;

import org.example.friendexam.도메인.POST;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FriendRepository extends CrudRepository<POST,Long>, PagingAndSortingRepository<POST,Long> {
}





    //CrudRepository에 스프링 JDBC가 필요한 부분이 들어있다.
    // 제네릭으로 Friend 클래스와 아이디의 타입을 써 주어야 한다.

