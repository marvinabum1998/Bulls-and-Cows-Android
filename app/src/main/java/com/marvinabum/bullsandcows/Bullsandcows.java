package com.marvinabum.bullsandcows;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

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
    private static final String BINARY = "608060405260008055600060015534801561001957600080fd5b50610265806100296000396000f3fe6080604052600436106100615763ffffffff7c0100000000000000000000000000000000000000000000000000000000600035041663391be9c1811461006657806389a71ac91461008d5780639048b5cf146100b9578063e1c3857f146100ce575b600080fd5b34801561007257600080fd5b5061007b6100f8565b60408051918252519081900360200190f35b34801561009957600080fd5b506100b7600480360360208110156100b057600080fd5b50356100fe565b005b3480156100c557600080fd5b5061007b610163565b3480156100da57600080fd5b506100b7600480360360208110156100f157600080fd5b5035610169565b60015490565b600060046103e85b600a811061014c57808481151561011957fe5b0460008181526002602052604090208390559250808481151561013857fe5b0693506000199190910190600a9004610106565b505050600090815260026020526040902060019055565b60005490565b600080805560018190556004906103e85b600a811061023357808481151561018d57fe5b04600081815260026020526040902054909250156101d2576000828152600260205260409020548314156101c9576000805460010190556101d2565b60018054810190555b80848115156101dd57fe5b06600081815260026020526040902054909450600019909301921561022a57600084815260026020526040902054600114156102215760008054600101905561022a565b60018054810190555b600a900461017a565b5050505056fea165627a7a723058200902afc9b83ff1b0207c1869569c9627438ba2f3bca65aa6695190c6e2c55d980029";

    public static final String FUNC_GETCOWS = "getCows";

    public static final String FUNC_SETPOSITION = "setPosition";

    public static final String FUNC_GETBULLS = "getBulls";

    public static final String FUNC_CHECKGUESS = "checkGuess";

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

    public RemoteCall<BigInteger> getCows() {
        final Function function = new Function(FUNC_GETCOWS,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
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
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
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