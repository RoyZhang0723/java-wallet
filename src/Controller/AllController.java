package Controller;

import Service.UserWalletService;
import Service.WalletTransactionsService;
import pojo.Result;
import pojo.SearchTransactionsReq;
import pojo.UserWalletInf;
import pojo.WalletTransactions;
import pojo.getBalanceReq;
import pojo.getBalanceResult;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AllController {
    @Autowired
    WalletTransactionsService walletTransactionsService;

    @Autowired
    UserWalletService userWalletService;

    @CrossOrigin
    @PostMapping("api/getBalance")
    public getBalanceResult getBalance(@RequestBody getBalanceReq req) throws Exception {
        int user_id = req.getUser_id();
        UserWalletInf userWalletInf = userWalletService.get(user_id);
        getBalanceResult result = new getBalanceResult();
        result.setBalance(userWalletInf.getBalance());
        return result;
    }

    @CrossOrigin
    @PostMapping("api/purchase")
    public Result purchase(@RequestBody WalletTransactions walletTransactions) throws Exception {
        int amount = walletTransactions.getAmount();
        int user_id = walletTransactions.getUser_id();
        if (userWalletService.get(user_id) == null) {
            return new Result(400);
        }
        int balance = userWalletService.get(user_id).getBalance();
        int new_balance = balance - amount;
        UserWalletInf userWalletInf1 = new UserWalletInf();
        userWalletInf1.setUser_id(user_id);
        userWalletInf1.setBalance(new_balance);
        userWalletService.addorUpdate(userWalletInf1);
        WalletTransactions walletTransactions1 = new WalletTransactions();
        walletTransactions1.setTransaction_type("purchase");
        walletTransactions1.setAmount(amount);
        walletTransactions1.setUser_id(user_id);
        walletTransactions1.setCreated_at(System.currentTimeMillis());
        return new Result(200);
    }

    @CrossOrigin
    @PostMapping("api/refund")
    public Result refund(@RequestBody WalletTransactions walletTransactions) throws Exception {
        int amount = walletTransactions.getAmount();
        int user_id = walletTransactions.getUser_id();
        if (userWalletService.get(user_id) == null) {
            return new Result(400);
        }
        int balance = userWalletService.get(user_id).getBalance();
        int new_balance = balance + amount;
        UserWalletInf userWalletInf1 = new UserWalletInf();
        userWalletInf1.setUser_id(user_id);
        userWalletInf1.setBalance(new_balance);
        userWalletService.addorUpdate(userWalletInf1);
        WalletTransactions walletTransactions1 = new WalletTransactions();
        walletTransactions1.setTransaction_type("refund");
        walletTransactions1.setAmount(amount);
        walletTransactions1.setUser_id(user_id);
        walletTransactions1.setCreated_at(System.currentTimeMillis());
        return new Result(200);
    }

    @CrossOrigin
    @PostMapping("api/search")
    public List<WalletTransactions> search(@RequestBody SearchTransactionsReq searchTransactionsReq) throws Exception {
        Integer userId = searchTransactionsReq.getUserId();
        WalletTransactions walletTransactions = walletTransactionsService.get(userId);
        List<WalletTransactions> l = new ArrayList<>();
        l.add(walletTransactions);
        return l;
    }

}
