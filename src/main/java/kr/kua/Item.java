package kr.kua;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
// Inheritance를 적용하지 않으면 InheritanceType.SINGLE_TABLE 로 자동 적용되어 구성 됨
@DiscriminatorColumn // DTYPE
public abstract class Item { // 가상화로 선언하는 것을 추천(SINGLE_TABLE 이 아닐떄만)

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
