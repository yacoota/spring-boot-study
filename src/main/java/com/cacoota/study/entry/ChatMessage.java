package com.cacoota.study.entry;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessage implements Serializable {

    public ChatMessage(String message) {
        this.message = message;
    }

    public ChatMessage(String receiver, String message) {
        this.receiver = receiver;
        this.message = message;
    }

    private String message;

    private String sender;

    private String receiver;


}
