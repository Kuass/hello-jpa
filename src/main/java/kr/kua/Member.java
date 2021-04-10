package kr.kua;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Member extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

//    @Column(name = "TEAM_ID")
//    private Long teamId;

    @ManyToOne(fetch = FetchType.LAZY) // LAZY 를 가급적 사용하자.
    @JoinColumn(name = "TEAM_ID")      // DB에 FK가 생기면 생길수록 JPA 구조에서는 한번에(EAGER) 가져오게 되면
    private Team team;                 // 모든 테이블에 SELECT 가 진행이 된다. ㄷㄷㄷㄷ

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) { this.team = team; }
}

