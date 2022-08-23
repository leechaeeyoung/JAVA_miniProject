package com.example.board.controller;

import com.example.board.Repository.BoardRepository;
import com.example.board.dto.BoardDto;
import com.example.board.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class BoardController {
    private final BoardService boardService;
    /* 게시글 목록 */
    @GetMapping("/")
    public String list(Model model) {
        List<BoardDto> boardList = boardService.getBoardlist();

        model.addAttribute("boardList",boardList);
        return "board/list.html";
    }
    /* 게시글 상세 */
    @GetMapping("/post/{no}")
    public String detail(@PathVariable("no")Long no, Model model){
        BoardDto boardDTO = boardService.getPost(no);
        model.addAttribute("boardDto",boardDTO);
        return "board/detail.html";
    }
    /* 게시글 수정페이지 */
    @GetMapping("/post/edit/{no}")
    public String edit(@PathVariable("no")Long no, Model model){
        BoardDto boardDTO = boardService.getPost(no);
        model.addAttribute("boardDto",boardDTO);
        return "board/update.html";
    }
    /* 게시글 수정 */
    @PutMapping("/post/edit/{no}")
    public String update(BoardDto boardDTO){
        boardService.savePost(boardDTO);
        return "redirect:/";
    }
    /* 게시글 삭제 */
    @DeleteMapping("/post/{no}")
    public String delete(@PathVariable("no")Long no){
        boardService.deletePost(no);
        return "redirect:/";
    }

    @GetMapping("/post")
    public String write() {
        return "board/write.html";
    }

    @PostMapping("/post")
    public String write(BoardDto boardDto) {
        boardService.savePost(boardDto);

        return "redirect:/";
    }
}
