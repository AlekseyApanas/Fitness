package core.dto;

import java.util.List;
import java.util.Objects;

public class UserPageDTO {
    private int number;

    private int size;

    private int totalPages;

    private long totalElements;

    private boolean first;

    private long numberOfElements;

    private boolean last;

    private List<SaveUserDTO> user;

    public UserPageDTO(int number, int size, int totalPages, long totalElements, boolean first, long numberOfElements, boolean last, List<SaveUserDTO> user) {
        this.number = number;
        this.size = size;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.first = first;
        this.numberOfElements = numberOfElements;
        this.last = last;
        this.user = user;
    }

    public UserPageDTO() {
    }

    public int getNumber() {
        return number;
    }

    public int getSize() {
        return size;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public boolean isFirst() {
        return first;
    }

    public long getNumberOfElements() {
        return numberOfElements;
    }

    public boolean isLast() {
        return last;
    }

    public List<SaveUserDTO> getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPageDTO that = (UserPageDTO) o;
        return number == that.number && size == that.size && totalPages == that.totalPages && totalElements == that.totalElements && first == that.first && numberOfElements == that.numberOfElements && last == that.last && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, size, totalPages, totalElements, first, numberOfElements, last, user);
    }

    @Override
    public String toString() {
        return "UserPageDTO{" +
                "number=" + number +
                ", size=" + size +
                ", totalPages=" + totalPages +
                ", totalElements=" + totalElements +
                ", first=" + first +
                ", numberOfElements=" + numberOfElements +
                ", last=" + last +
                ", user=" + user +
                '}';
    }
}

