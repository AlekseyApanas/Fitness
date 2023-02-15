package dto;

import java.util.List;

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
}

