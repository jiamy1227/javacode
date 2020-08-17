package javaee.ChannelSftp;

import java.io.*;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import sun.dc.path.PathError;

public class FtpsFileList {
    private static final Logger LOG = Logger.getLogger(FtpsFileList.class);

    private static ChannelSftp sftp = null;
    private static Channel channel = null;
    private static Session sshSession = null;
    private static String src = "/xml";
    private static String localDownPath = "D:\\filepath\\download";
    private static String localUpPath = "D:\\filepath\\upfile";

    public static void main(String[] args) {

        Security.insertProviderAt(new BouncyCastleProvider(),1);
        //Security.addProvider(new BouncyCastleProvider());


        channel = getChannel("djrcfeed.dowjones.com", 22, "jadsWL", "Jad1034");//serve Ip,port,username,pwd
        List<String> str = listFileNames(channel, src);
        System.out.println("目录下包含的文件名称为：" + str);
        for (String a : str) {
            System.out.println("文件名为：" + a);
        }

        //download file from serve
        //getFileFromSftpServer(channel, src, localDownPath);

        //upload file to serve from local
        //putFileToSftpServer(channel,src,localUpPath);

        closeResource(channel, sftp, sshSession);
    }

    private static List<String> listFileNames(Channel channel, String dir) {
        List<String> list = new ArrayList<String>();
        ChannelSftp sftp = null;
        try {
            sftp = (ChannelSftp) channel;
            Vector vector = sftp.ls(dir);//获取文件列表
            for (Object item : vector) {
                if (item instanceof com.jcraft.jsch.ChannelSftp.LsEntry) {
                    String fileName = ((com.jcraft.jsch.ChannelSftp.LsEntry) item).getFilename();
                    if (fileName.equals(".") || fileName.equals("..")) {
                        continue;
                    }
                    System.out.println(fileName);
                    list.add(fileName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private static void getFileFromSftpServer(Channel channel, String src, String localPath) {
        ChannelSftp sftp = null;

        try {
            sftp = (ChannelSftp) channel;
            Vector vector = sftp.ls(src);//获取文件目录下所有的文件
            for (Object item : vector) {
                if (item instanceof com.jcraft.jsch.ChannelSftp.LsEntry) {
                    String fileName = ((com.jcraft.jsch.ChannelSftp.LsEntry) item).getFilename();
                    if (fileName.equals(".") || fileName.equals("..")) {
                        continue;
                    }
                    System.out.println(fileName);
                    File localpath = new File(localPath);
                    File[] fileList = localpath.listFiles();
                    if (!localpath.exists()) {
                        localpath.mkdirs();
                        localPath = localpath.getPath();
                    }
                    for (File file : fileList) {
                        if (fileName.equals(file.getName())) {
                            file.delete();
                        }
                    }
                    System.out.println(localPath);
                    String localFileName = localPath + File.separator + fileName;

                    sftp.get(src + "/" + fileName, localPath);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void putFileToSftpServer(Channel channel, String src, String localPath) {
        List<String> list = new ArrayList<String>();
        try {
            sftp = (ChannelSftp) channel;
            File file = new File(localPath);
            if (!file.exists()) {
                throw new PathError("本地路径有误");
            }
            File[] files = file.listFiles();
            for (File item : files) {
                list.add(item.getName());
                System.out.println("getPath:" + item.getPath());
                sftp.put(localPath + File.separator + item.getName(), src);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Channel getChannel(String host, int port, String username, final String password) {

        try {
            JSch jsch = new JSch();
            jsch.getSession(username, host, port);
            sshSession = jsch.getSession(username, host, port);
            sshSession.setPassword(password);
            Properties sshConfig = new Properties();
            sshConfig.put("StrictHostKeyChecking", "no");
            sshSession.setConfig(sshConfig);
            sshSession.connect();
            LOG.debug("Session connected!");
            channel = sshSession.openChannel("sftp");
            channel.connect();
            LOG.debug("Channel connected!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return channel;
    }

    private static void closeResource(Channel channel, ChannelSftp sftp, Session session) {
        if (channel != null) {
            if (channel.isConnected()) {
                channel.disconnect();
            }
        }
        if (sftp != null) {
            if (sftp.isConnected()) {
                sftp.disconnect();
            }
        }
        if (session != null) {
            if (session.isConnected()) {
                session.disconnect();
            }
        }
    }

}
