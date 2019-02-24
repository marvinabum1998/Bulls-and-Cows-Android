package com.marvinabum.bullsandcows;

import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) throws Exception {
        ContractWrapper wrapper = new ContractWrapper();
        Bullsandcows contract = wrapper.getContract();

        BigInteger secret = new BigInteger("1234");
        RemoteCall<TransactionReceipt> receipt = contract.setPosition(secret);
        TransactionReceipt future = receipt.send();

        System.out.println("The status is " + future.getStatus());

        contract.checkGuess(new BigInteger("1234")).send();

        RemoteCall<BigInteger> rcCows =  contract.getCows();
        BigInteger cows = rcCows.send();
        System.out.println("The status is " + cows);

        RemoteCall<BigInteger> rcBulls =  contract.getBulls();
        BigInteger bulls = rcBulls.send();
        System.out.println("The status is " + bulls);

    }
}