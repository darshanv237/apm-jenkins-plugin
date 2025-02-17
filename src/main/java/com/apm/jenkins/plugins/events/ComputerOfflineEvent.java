package com.apm.jenkins.plugins.events;

import hudson.model.Computer;
import hudson.slaves.OfflineCause;
import com.apm.jenkins.plugins.APMUtil;

import java.util.HashMap;


public class ComputerOfflineEvent extends AbstractAPMSimpleEvent {

    public ComputerOfflineEvent(Computer computer, OfflineCause cause, boolean isTemporarily) {
        
        String nodeName = APMUtil.getNodeName(computer);
        
        String title = "Jenkins node " + nodeName + " is" + (isTemporarily? " temporarily ": " ") + "offline";
        setTitle(title);

        // TODO: Add more info about the case in the event in message.
        String text = "Jenkins node " + nodeName + " is" + (isTemporarily? " temporarily ": " ") + "offline." +
                "\n" + super.getLocationDetails() + "\n";
        setText(text);

        setPriority(Priority.NORMAL);
        setAlertType(AlertType.WARNING);
        
        //Snappyflow Specific
        // setSnappyflowTags(tags);
    }
}