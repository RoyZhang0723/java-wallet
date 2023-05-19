package pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "user_wallet")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})

public class UserWalletInf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int user_id;

    int balance;

    public int getBalance() {
        return balance;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
