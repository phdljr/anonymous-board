package com.phdljr.anonymousboard.controller;

import com.phdljr.anonymousboard.controller.dto.request.BoardRequestDto;
import com.phdljr.anonymousboard.controller.dto.response.BoardResponseDto;
import com.phdljr.anonymousboard.service.BoardService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/boards")
    public ResponseEntity<List<BoardResponseDto>> getBoards() {
        List<BoardResponseDto> boards = boardService.getBoards();
        return ResponseEntity.ok(boards);
    }

    @GetMapping("/boards/{boardId}")
    public ResponseEntity<BoardResponseDto> getBoard(@PathVariable Long boardId) {
        BoardResponseDto board = boardService.getBoard(boardId);
        return ResponseEntity.ok(board);
    }

    @PostMapping("/boards")
    public ResponseEntity<BoardResponseDto> createBoard(
        @RequestBody BoardRequestDto boardRequestDto) {
        BoardResponseDto board = boardService.createBoard(boardRequestDto);
        return ResponseEntity.ok(board);
    }

    @PutMapping("/boards/{boardId}")
    public ResponseEntity<BoardResponseDto> updateBoard(@PathVariable Long boardId,
        @RequestHeader(value = "Password") String password,
        @RequestBody BoardRequestDto boardRequestDto) {
        BoardResponseDto board = boardService.updateBoard(boardId, password, boardRequestDto);
        return ResponseEntity.ok(board);
    }

    @DeleteMapping("/boards/{boardId}")
    public ResponseEntity<Long> deleteBoard(@PathVariable Long boardId,
        @RequestHeader(value = "Password") String password) {
        Long id = boardService.deleteBoard(boardId, password);
        return ResponseEntity.ok(id);
    }
}
