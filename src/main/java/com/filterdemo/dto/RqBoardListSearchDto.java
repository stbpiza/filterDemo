package com.filterdemo.dto;

import com.filterdemo.entity.BoardOrderType;
import com.filterdemo.entity.PostType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
public class RqBoardListSearchDto {

    private PostType type;

    private String language;

    private BoardOrderType order;
}
