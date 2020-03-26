package com.cloud.ningshanshui.backup.service.impl;

import com.cloud.ningshanshui.backup.service.MysqlBackupService;
import com.cloud.ningshanshui.backup.util.MySqlBackupRestoreUtils;
import org.springframework.stereotype.Service;

/**
 * <p>Title: </p>
 * <p>Company: 纬度网络能源</p>
 *
 * @version 1.0
 * @KaiFaAuthor 宁山水
 * @date 2020-03-26 14:19
 */

@Service
public class MysqlBackupServiceImpl implements MysqlBackupService {


    @Override
    public boolean backup(String host, String userName, String password, String backupFolderPath, String fileName,
                          String database) throws Exception {
        return MySqlBackupRestoreUtils.backup(host, userName, password, backupFolderPath, fileName, database);
    }


    @Override
    public boolean restore(String restoreFilePath, String host, String userName, String password, String database)
            throws Exception {
        return MySqlBackupRestoreUtils.restore(restoreFilePath, host, userName, password, database);
    }

}
