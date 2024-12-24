CREATE TABLE IF NOT EXISTS todo (
                                    id          BIGSERIAL,
                                    content     TEXT,

                                    status      VARCHAR(255),
    created_at  TIMESTAMP       DEFAULT NOW(),
    updated_at  TIMESTAMP,
    deleted_At  TIMESTAMP

    CONSTRAINT pk_todo PRIMARY KEY (id)
    );

-- 테이블 코멘트
COMMENT ON TABLE todo IS '할 일 관리';

-- 컬럼 코멘트
COMMENT ON COLUMN todo.content     IS '할 일 내용';
COMMENT ON COLUMN todo.status      IS '상태';
COMMENT ON COLUMN todo.created_at  IS '생성일';
COMMENT ON COLUMN todo.updated_at  IS '마지막 수정일';
COMMENT ON COLUMN todo.deleted_At  IS '삭제일';
