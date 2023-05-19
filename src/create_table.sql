CREATE TABLE `user_wallet`
(
    `user_id` INT(11) NOT NULL PRIMARY KEY,
    `balance` DECIMAL(10, 2) NOT NULL
);

CREATE TABLE `wallet_transactions`
(
    `transaction_id`   INT(11) AUTO_INCREMENT PRIMARY KEY,
    `user_id`          INT(11) NOT NULL,
    `amount`           DECIMAL(10, 2) NOT NULL,
    `transaction_type` ENUM('deposit', 'purchase', 'refund', 'withdraw') NOT NULL,
    `created_at`       TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
);