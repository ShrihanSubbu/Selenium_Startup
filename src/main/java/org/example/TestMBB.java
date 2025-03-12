package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestMBB {

    //'entre the otp for the corresponding transaction'
    //'your OTP si 0123456 for interbank transaction'
    //'your OPT for reg is 984564 for creaditcard applictaion'

    private static Logger logger;
    public static void main(String[] args) {


        logger = LogManager.getLogger(TestMBB.class);
        String fetchotp = "your OTP is 12345 for 12354 interbank transaction";

        logger.info("test1");

        fetchotp = fetchotp.replaceAll("[^\\d]", " ").trim().replaceAll(" +", " ");
        //fetchotp = fetchotp.trim();
        //fetchotp = fetchotp.replace(" +", " ");
        if (fetchotp.equals(""))
            fetchotp = "there is no number";

        System.out.println(fetchotp);

    }

}
