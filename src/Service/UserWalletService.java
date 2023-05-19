package Service;

import DAO.UserWalletDAO;
import pojo.UserWalletInf;

public class UserWalletService {
    @Autowired
    UserWalletDAO userWalletDAO;

    public UserWalletInf get(Integer user_id) {
        return userWalletDAO.findByUSER_ID(user_id);
    }

    public void addorUpdate(UserWalletInf userWalletInf) {
        userWalletDAO.save(userWalletInf);
    }

    public void delete_user(Integer id) {
        userWalletDAO.deleteByUSER_ID(id);
    }
}
