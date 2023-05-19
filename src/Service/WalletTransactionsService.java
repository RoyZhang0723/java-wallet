package Service;

import DAO.WalletTransactionsDAO;
import pojo.WalletTransactions;

import java.util.List;

public class WalletTransactionsService {
    @Autowired
    WalletTransactionsDAO walletTransactionsDAO;

    public WalletTransactions get(Integer user_id) {
        return walletTransactionsDAO.findByUSER_ID(user_id);
    }

    public List<WalletTransactions> list() {
        return walletTransactionsDAO.findALL();
    }

    public void addorUpdate(WalletTransactions walletTransactions) {
        walletTransactionsDAO.save(walletTransactions);
    }

    public void delete_trans(int transaction_id) {
        walletTransactionsDAO.deleteById(transaction_id);
    }
}
