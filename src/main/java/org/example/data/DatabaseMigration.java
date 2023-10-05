package org.example.data;

import org.apache.log4j.Logger;
import org.flywaydb.core.Flyway;

import static org.example.data.Config.*;

public class DatabaseMigration{

   private static final Logger logger = Logger.getLogger(DatabaseMigration.class);

    private DatabaseMigration() {

    }
    private void fwMigration() {
        logger.debug("Flyway migration execute");

        Flyway.configure()
                .dataSource(JDBC_URL, USERNAME, PASSWORD)
                .locations("classpath:flyway/scripts")
                .load()
                .migrate();
    }
}

