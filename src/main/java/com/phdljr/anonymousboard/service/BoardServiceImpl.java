package com.phdljr.anonymousboard.service;

import com.phdljr.anonymousboard.controller.dto.request.BoardRequestDto;
import com.phdljr.anonymousboard.controller.dto.response.BoardResponseDto;
import com.phdljr.anonymousboard.domain.Board;
import com.phdljr.anonymousboard.exception.type.NotFoundBoardException;
import com.phdljr.anonymousboard.exception.type.WrongPasswordException;
import com.phdljr.anonymousboard.repository.BoardRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    @Transactional(readOnly = true)
    public List<BoardResponseDto> getBoards() {
        return boardRepository.findAll()
            .stream()
            .map(Board::toResponseDto)
            .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public BoardResponseDto getBoard(final Long boardId) {
        return findById(boardId).toResponseDto();
    }

    @Override
    public BoardResponseDto createBoard(final BoardRequestDto boardRequestDto) {
        Board result = Board.builder()
            .title(boardRequestDto.getTitle())
            .createdBy(boardRequestDto.getCreatedBy())
            .password(boardRequestDto.getPassword())
            .contents(boardRequestDto.getContents())
            .build();
        return boardRepository.save(result).toResponseDto();
    }

    @Override
    @Transactional
    public BoardResponseDto updateBoard(final Long boardId, final String password,
        final BoardRequestDto boardRequestDto) {
        Board board = findById(boardId);

        confirm(board, password);

        board.updateContents(
            boardRequestDto.getTitle(),
            boardRequestDto.getCreatedBy(),
            boardRequestDto.getContents()
        );
        return board.toResponseDto();
    }

    @Override
    public Long deleteBoard(final Long boardId, final String password) {
        Board board = findById(boardId);

        confirm(board, password);

        boardRepository.delete(board);
        return boardId;
    }

    private void confirm(final Board board, final String password) {
        if (!board.confirmPassword(password)) {
            throw new WrongPasswordException();
        }
    }

    private Board findById(final Long boardId) {
        return boardRepository.findById(boardId)
            .orElseThrow(NotFoundBoardException::new);
    }
}
