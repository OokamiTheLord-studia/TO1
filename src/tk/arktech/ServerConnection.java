package tk.arktech;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;


public class ServerConnection {
    private URL adres;
    private String filepath;


    public ServerConnection(String adres, String filepath) {
        try {
            this.adres = new URL(adres);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        this.filepath = filepath;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }



    public void downloadFile()
    {
        ReadableByteChannel rbcObj = null;
        FileOutputStream foStream = null;

        if(!Files.exists(Paths.get(filepath)))
        {


            try {
                Files.createFile(Paths.get(filepath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            rbcObj = Channels.newChannel(adres.openStream());
            foStream = new FileOutputStream(filepath);
            foStream.getChannel().transferFrom(rbcObj, 0, Long.MAX_VALUE);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rbcObj != null)
                {
                    rbcObj.close();
                }

                if(foStream != null)
                {
                    foStream.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    public String getAdres() {
        return adres.toString();
    }

    public void setAdres(String adres) {
        try {
            this.adres = new URL(adres);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
