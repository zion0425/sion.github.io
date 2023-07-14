package sion.hellospring.repository;

import org.springframework.stereotype.Repository;
import sion.hellospring.domain.Member;

import java.util.*;

@Repository
public class MemoryMemberRepository implements  MemberRepository{

    // 공유되는 변수이므로 공유문제가 발생하므로, 실제론 ConcurrentHashMap, AtomicLong 사용해야 한다.
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }

}
