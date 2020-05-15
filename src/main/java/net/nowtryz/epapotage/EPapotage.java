package net.nowtryz.epapotage;


import net.nowtryz.epapotage.entity.Bavard;
import net.nowtryz.epapotage.gui.BavardWindow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EPapotage {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("Starting EPapotage..");

        new BavardWindow(new Bavard("Admin"));
        new BavardWindow(new Bavard("User"));
    }
}
