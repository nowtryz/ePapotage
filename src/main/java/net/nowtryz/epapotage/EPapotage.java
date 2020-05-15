package net.nowtryz.epapotage;


import net.nowtryz.epapotage.gui.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EPapotage {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("Starting EPapotage..");

        new LoginPage();
    }
}
