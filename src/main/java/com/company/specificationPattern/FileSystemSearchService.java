package com.company.specificationPattern;

import java.io.File;
import java.util.List;

import io.micrometer.core.lang.Nullable;

class FileSystemSearchService {
    public List<File> searchFilesExample() {
        Specification mySpec = FilesSpecifications.nameIs("abc").and(FileSpecifications.sizeInGbIs(10));
        return new FileSystem().findAll(mySpec);
    }   
}

class FileSpecifications {
    static Specification nameIs(String name) {
        return file -> file.getName().equals(name);
    }

    static Specification sizeInGbIs(Integer size) {
        return file -> file.getSizeinGb().equals(size);
    }
}

interface Specification {
    boolean test(T candidate);
    Specification<T> not(@Nullable Specification<T> spec);
    Specification<T> and(@Nullable Specification<T> other);
    ...
    ...
    Predicate<T> toPredicate();
}

interface FileSystem<T> {
    Optional<T> findOne(@Nullable Specification<T> spec);
    List<T> findAll(@Nullable Specification<T> spec);
}

