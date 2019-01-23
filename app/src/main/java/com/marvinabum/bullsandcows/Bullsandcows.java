package com.marvinabum.bullsandcows;

import com.kenai.jffi.Main;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.tx.Contract;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import javax.crypto.Cipher;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.6.0.
 */
public class Bullsandcows extends Contract {
    private static final String BINARY = "608060405260008055600060015534801561001957600080fd5b50610320806100296000396000f3fe608060405260043610610062576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063391be9c11461006757806389a71ac9146100925780639048b5cf146100cd578063e1c3857f146100f8575b600080fd5b34801561007357600080fd5b5061007c610133565b6040518082815260200191505060405180910390f35b34801561009e57600080fd5b506100cb600480360360208110156100b557600080fd5b810190808035906020019092919050505061013d565b005b3480156100d957600080fd5b506100e26101ca565b6040518082815260200191505060405180910390f35b34801561010457600080fd5b506101316004803603602081101561011b57600080fd5b81019080803590602001909291905050506101d3565b005b6000600154905090565b600080905060006004905060006103e890505b600a811015156101ab57808481151561016557fe5b049250816002600085815260200190815260200160002081905550808481151561018b57fe5b069350818060019003925050600a818115156101a357fe5b049050610150565b5060016002600085815260200190815260200160002081905550505050565b60008054905090565b600060049050600080905060006103e890505b600a811015156102ee5780848115156101fb57fe5b0491506000600260008481526020019081526020016000205414151561026057826002600084815260200190815260200160002054141561024c57600080815480929190600101919050555061025f565b6001600081548092919060010191905055505b5b808481151561026b57fe5b069350828060019003935050600060026000868152602001908152602001600020541415156102da576001600260008681526020019081526020016000205414156102c65760008081548092919060010191905055506102d9565b6001600081548092919060010191905055505b5b600a818115156102e657fe5b0490506101e6565b5050505056fea165627a7a723058203517ca949c8175c37bb4f3b8b1dbaab390c2e66aed9c90d9e164fe73aa1ac4b00029";

    public static final String FUNC_GETCOWS = "getCows";

    public static final String FUNC_SETPOSITION = "setPosition";

    public static final String FUNC_GETBULLS = "getBulls";

    public static final String FUNC_CHECKGUESS = "checkGuess";

    private final static String PRIVATE_KEY = "2A4072121BDD59246A2DB4E912F1D83B964A8127FC17C27869FE000986E055CF";

    private final static BigInteger GAS_LIMIT = BigInteger.valueOf(21000L);

    private final static BigInteger GAS_PRICE = BigInteger.valueOf(2000000000L);

    @Deprecated
    protected Bullsandcows(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Bullsandcows(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Bullsandcows(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Bullsandcows(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    protected Bullsandcows(String contractBinary, String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider gasProvider) {
        super(contractBinary, contractAddress, web3j, transactionManager, gasProvider);
    }

    public RemoteCall<BigInteger> getCows() {
        final Function function = new Function(FUNC_GETCOWS,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {
                }));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> setPosition(BigInteger secret) {
        final Function function = new Function(
                FUNC_SETPOSITION,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(secret)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getBulls() {
        final Function function = new Function(FUNC_GETBULLS,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {
                }));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> checkGuess(BigInteger guess) {
        final Function function = new Function(
                FUNC_CHECKGUESS,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(guess)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<Bullsandcows> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Bullsandcows.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Bullsandcows> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Bullsandcows.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Bullsandcows> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Bullsandcows.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Bullsandcows> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Bullsandcows.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static Bullsandcows load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Bullsandcows(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Bullsandcows load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Bullsandcows(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Bullsandcows load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Bullsandcows(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Bullsandcows load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Bullsandcows(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
