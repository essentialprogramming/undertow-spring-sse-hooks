package com.controller;

import com.sun.deploy.net.HttpResponse;
import com.util.SseEmitters;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * @author Ovidiu Lapusan
 */
@Controller
@RequestMapping("/sse")
public class HookController {

	private final SseEmitters emitters = new SseEmitters();

	@GetMapping(path = "/hook", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public SseEmitter getHook() {
		return emitters.add();
	}

	@PostMapping(path = "/sendHook", consumes = "application/json")
	public ResponseEntity retreiveHook(@RequestBody String content) {
		emitters.send(content);
		return new ResponseEntity(HttpStatus.OK);
	}
}
