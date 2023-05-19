package DAO;

import pojo.UserWalletInf;

public interface UserWalletDAO extends JpaRepository<UserWalletInf, Integer>{
    UserWalletInf findByUSER_ID(Integer user_id);
}
