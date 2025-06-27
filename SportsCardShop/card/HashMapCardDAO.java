package SportsCardShop.card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapCardDAO implements CardDAO {

    protected Map<Integer, CardVO> cardMap = new HashMap<>();
    protected int cardSeq = 1;

    @Override
    public boolean insert(CardVO card) {
        if (card == null) return false;

        if (card.getCardId() == 0) {
            card.setCardId(cardSeq++);
        } else if (card.getCardId() >= cardSeq) {
            cardSeq = card.getCardId() + 1;
        }
        cardMap.put(card.getCardId(), card);
        return true;
    }

    
    
    @Override
    public boolean remove(int cardId) {
        return cardMap.remove(cardId) != null;
    }

    @Override
    public boolean updateStock(int cardId, int newStock) {
        CardVO card = cardMap.get(cardId);
        if (card != null) {
            card.setStock(newStock);
            return true;
        }
        return false;
    }

    @Override
    public List<CardVO> selectAll() {
        return new ArrayList<>(cardMap.values());
    }

    @Override
    public List<CardVO> selectPopular() {
        List<CardVO> result = new ArrayList<>();
        for (CardVO card : cardMap.values()) {
            if (card.isPopular()) {
                result.add(card);
            }
        }
        return result;
    }

    @Override
    public List<CardVO> search(String keyword) {
        List<CardVO> result = new ArrayList<>();
        for (CardVO card : cardMap.values()) {
            if (card.getName().contains(keyword) ||
                card.getTeam().contains(keyword) ||
                card.getCategory().contains(keyword)) {
                result.add(card);
            }
        }
        return result;
    }

    @Override
    public List<CardVO> filter(CardSearchCondition cond) {
        List<CardVO> result = new ArrayList<>();
        for (CardVO card : cardMap.values()) {

            // 🔍 키워드 (이름/팀/카테고리) 소문자 포함 여부
            if (cond.getKeyword() != null && !cond.getKeyword().isBlank()) {
                String kw = cond.getKeyword().toLowerCase();
                if (!card.getName().toLowerCase().contains(kw) &&
                    !card.getTeam().toLowerCase().contains(kw) &&
                    !card.getCategory().toLowerCase().contains(kw)) continue;
            }

            if (cond.getMinPrice() != null && card.getPrice() < cond.getMinPrice()) continue;
            if (cond.getMaxPrice() != null && card.getPrice() > cond.getMaxPrice()) continue;

            // 🔍 등급 비교 (공백 무시 + 대소문자 무시)
            if (cond.getGrade() != null && !cond.getGrade().isBlank()) {
                if (!card.getGrade().equalsIgnoreCase(cond.getGrade().trim())) continue;
            }

            // 🔍 연도는 0일 경우 스킵
            if (cond.getYear() != null && cond.getYear() != 0) {
                if (!cond.getYear().equals(card.getYear())) continue;
            }

            // 🔍 브랜드 비교 (공백 무시 + 대소문자 무시)
            if (cond.getBrand() != null && !cond.getBrand().isBlank()) {
                if (!card.getBrand().equalsIgnoreCase(cond.getBrand().trim())) continue;
            }

            // 🔍 재고 체크
            if (cond.getInStockOnly() != null && cond.getInStockOnly()) {
                if (card.getStock() <= 0) continue;
            }

            result.add(card);
        }
        return result;
    }


    @Override
    public CardVO getCardById(int cardId) {
        return cardMap.get(cardId);
    }
}
