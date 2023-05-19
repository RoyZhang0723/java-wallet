package DAO;

import pojo.WalletTransactions;

public interface WalletTransactionsDAO extends  JpaRepository<WalletTransactions,Integer>{
    WalletTransactions findByUSER_ID(Integer user_id);
}
