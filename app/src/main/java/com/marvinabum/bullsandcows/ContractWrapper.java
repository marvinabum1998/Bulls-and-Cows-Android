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
import org.web3j.tx.gas.ContractGasProvider;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.lang.String;

public class ContractWrapper {

// THIS IS A SEPARATE CLASS WITHIN THE APP TO REMOTELY DEPLOY AND LOAD THE SMART CONTRACT FOR USE WITHIN THE GAME

    private final static String PRIVATE_KEY = "2A4072121BDD59246A2DB4E912F1D83B964A8127FC17C27869FE000986E055CF";

    private final static String CONTRACT_ADDRESS = "0xc4bb204fadea0a8e2f26533e54fc0ebf367d4678";

    private final static BigInteger GAS_LIMIT = BigInteger.valueOf(300000L);

    private final static BigInteger GAS_PRICE = BigInteger.valueOf(2000000000L);

    private Credentials getCredentialsFromPrivateKey() {
        return Credentials.create(PRIVATE_KEY);
    }

    public Bullsandcows getContract() throws Exception {

        Web3j web3j = Web3j.build(new HttpService("https://kovan.infura.io/"));
        Web3ClientVersion web3ClientVersion = web3j.web3ClientVersion().send();
        System.out.println(web3ClientVersion.getWeb3ClientVersion());

        Credentials credentials = getCredentialsFromPrivateKey();

        Bullsandcows contract = loadContract(CONTRACT_ADDRESS, web3j, credentials);

        System.out.println("The deployed contract address is " + contract.toString());
        return contract;
    }

    private Bullsandcows loadContract(String contractAddress, Web3j web3j, Credentials credentials){
        return Bullsandcows.load(contractAddress, web3j, credentials, GAS_PRICE, GAS_LIMIT);
    }
}




