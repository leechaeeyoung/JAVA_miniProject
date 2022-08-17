package com.example.board.dto;

import com.example.board.entity.Board;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardResponseDto {
    private Long id;
    private String title;
    private String content;
    private int readCnt;
    private String registerId;
    private LocalDateTime registerTime;

    public BoardResponseDto(Board entity){
        this.id=entity.getId();
        this.title=entity.getTitle();
        this.content=entity.getContent();
        this.readCnt=entity.getReadCnt();
        this.registerId=entity.getRegisterId();
        this.registerTime=entity.getRegisterTime();
    }
    public String toString(){
        return "BoardListDto [id="+id+". title="+title+". content="+content
                +". readCnt="+readCnt+". registerId="+registerId+". registerTime="+registerTime+"]";
    }
}
