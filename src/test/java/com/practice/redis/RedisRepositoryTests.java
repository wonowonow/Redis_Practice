//package com.practice.redis;
//
//import static org.assertj.core.api.Assertions.*;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//public class RedisRepositoryTests {
//
//    @Autowired
//    private ItemRepository itemRepository;
//
//    @Test
//    public void createTest() {
//        Item item = Item.builder()
////                .id(1L) // 직접 넣을 수도 있다
//                .name("keyboard")
//                .description("description")
//                .price(100000)
//                .build();
//
//        itemRepository.save(item);
//        // id = Random Long Set
//        // id 기준으로 hash table 검색 후 매핑
//    }
//
//    @Test
//    public void readOneTest() {
//        Item item = itemRepository.findById(1L)
//                .orElseThrow();
//
//        assertThat(item.getDescription()).isEqualTo("description");
//    }
//
//    @Test
//    public void updateOneTest() {
//        Item item = itemRepository.findById(1L)
//                .orElseThrow();
//
//        item.setDescription("hello");
//        Item savedItem = itemRepository.save(item);
//
//        assertThat(savedItem.getDescription()).isEqualTo("hello");
//    }
//
//    @Test
//    void deleteOneTest() {
//        itemRepository.deleteById(1L);
//
//        assertThat(itemRepository.findById(1L).isPresent()).isFalse();
//    }
//}
