package pojo;

@Entity
@Table(name = "wallet_transactions")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class WalletTransactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int transaction_id;

    int user_id;
    int amount;
    String transaction_type;
    long created_at;

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public long getCreated_at() {
        return created_at;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public void setCreated_at(long created_at) {
        this.created_at = created_at;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }
}
