package com.cacoota.framework.socket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;

import java.security.Principal;
import java.util.Map;

@Component
@Slf4j
public class WebSocketHandshakeHandler extends DefaultHandshakeHandler {

    @Override
    protected Principal determineUser(ServerHttpRequest request, WebSocketHandler handler, Map<String, Object> attributes) {
        log.info("握手: {}, {}, {}, {}", request.getURI().getPath(), attributes, handler, request.getPrincipal());
        // 暂时用临时分配地址作为唯一标识
        return new WebSocketUser(request.getURI().getPath().replaceAll("/",""));
    }
}
