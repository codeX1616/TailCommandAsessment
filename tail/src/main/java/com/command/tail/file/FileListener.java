package com.command.tail.file;
import java.util.EventListener;

public interface FileListener extends EventListener {

    /**
     * File Event listener called on modification of file
     * @param event {@link FileEvent}
     */
    public void onModified(FileEvent event);

}