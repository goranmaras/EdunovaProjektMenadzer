/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.goranmaras.projektmenadzerzavrsni.util;

import hr.goranmaras.projektmenadzerzavrsni.util.slack.SlackPoruka;
import hr.goranmaras.projektmenadzerzavrsni.util.slack.SlackUtil;

/**
 *
 * @author Profesor
 */

public class EdunovaException extends Exception{
    
    private String poruka;

    public EdunovaException(String poruka) {
        this.poruka=poruka;
        
        //SLACK
        SlackPoruka slackMessage = SlackPoruka.builder()
                
        .username("GoranMaras")
        .text("SLACK BOT-->" + poruka)
        .icon_emoji(":twice:")
        .build();
        SlackUtil.sendMessage(slackMessage);
    }

    public String getPoruka() {
        return poruka;
    }
    
   
          
    
}
