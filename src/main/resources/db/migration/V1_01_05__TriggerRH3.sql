CREATE OR REPLACE FUNCTION checkexist()
  RETURNS TRIGGER AS $$
BEGIN
  IF ( SELECT rh.room_id 
  	  FROM public.room_history rh, public.room r 
  	  WHERE rh.id = r.history_id
  	  AND r.status_id = 'ACT'
  	  AND rh.room_id = NEW.room_id  ) 
   THEN RAISE EXCEPTION 'This Answer is an invalid date';
   END IF;
  RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER trigger_rh3
BEFORE INSERT ON public.room_history
FOR EACH ROW EXECUTE PROCEDURE checkexist();
