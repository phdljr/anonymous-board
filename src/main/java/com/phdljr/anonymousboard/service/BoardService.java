package com.phdljr.anonymousboard.service;

import com.phdljr.anonymousboard.controller.dto.request.BoardRequestDto;
import com.phdljr.anonymousboard.controller.dto.response.BoardResponseDto;
import java.util.List;

public interface BoardService {
    List<BoardResponseDto> getBoards();
    BoardResponseDto getBoard(Long boardId);
    BoardResponseDto createBoard(BoardRequestDto boardRequestDto);
    BoardResponseDto updateBoard(Long boardId, String password, BoardRequestDto boardRequestDto);
    Long deleteBoard(Long boardId, String password);
}
