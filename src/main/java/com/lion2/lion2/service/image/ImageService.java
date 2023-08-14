package com.lion2.lion2.service.image;

import com.lion2.lion2.dto.image.ImageResponseDTO;
import com.lion2.lion2.dto.image.ImageUploadDTO;

public interface ImageService {

//    /**
//     * 프로필 사진 upload
//     * @param imageUploadDTO file
//     * @param phone 유저 정보
//     */
    void upload(ImageUploadDTO imageUploadDTO, String phone);

//    /**
//     * 이미지 url 조회
//     * @param phone 유저 정보
//     * @return 이미지 url
//     */
    ImageResponseDTO findImage(String phone);
}